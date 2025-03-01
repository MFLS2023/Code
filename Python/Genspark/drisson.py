import random
import string
import requests
import time
from DrissionPage import Chromium, ChromiumOptions


class maildottm:
    def __init__(self):
        self.domains_response = requests.get("https://api.mail.tm/domains")
        self.domain = random.choice(
            [
                domain["domain"]
                for domain in self.domains_response.json()["hydra:member"]
            ]
        )
        self.email = (
            "".join(random.choices(string.ascii_lowercase + string.digits, k=10))
            + "@"
            + self.domain
        )
        self.account_data = {"address": self.email, "password": "I_loveyou3"}

        self.response = requests.post(
            "https://api.mail.tm/accounts", json=self.account_data
        )
        print(self.response.json())

        # 登录获取token
        token_response = requests.post(
            "https://api.mail.tm/token", json=self.account_data
        )
        print(token_response.json())
        self.token = token_response.json()["token"]

    def get_email(self):
        return self.email

    def get_verification_code(self):
        # 等待验证码邮件
        headers = {"Authorization": f"Bearer {self.token}"}

        for _ in range(30):
            messages = requests.get(
                "https://api.mail.tm/messages", headers=headers
            ).json()

            if messages["hydra:member"]:
                message_id = messages["hydra:member"][0]["id"]
                message = requests.get(
                    f"https://api.mail.tm/messages/{message_id}", headers=headers
                ).json()

                # 从邮件内容中提取验证码
                message_text = message["text"]
                if "Your code is: " in message_text:
                    return message_text.split("Your code is: ")[1].strip()[:6]
                break
            time.sleep(1)

        return None


class FailedVerificationCode(Exception):
    def __init__(self, message="Failed to get verification code"):
        self.message = message
        super().__init__(self.message)


def access_genspark():
    co = ChromiumOptions().set_browser_path(
        r"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
    )
    co.set_argument("--guest")
    co.no_imgs(True).mute(True)
    password = (
        "".join(
            random.choices(
                string.ascii_letters + string.digits,
                k=random.randint(8, 10),
            )
        )
        + "!"
    )
    mail = maildottm()
    invite_code = "MTMzMGJiNDdMNmI2MEwwMjk0TGQ4YThMYjkwOTQ2YjFmMTgy"

    browser = Chromium(addr_or_opts=co)
    tab = browser.latest_tab

    try:
        login_url = f"https://www.genspark.ai/invite?invite_code={invite_code}"
        tab.get(login_url)
        tab.ele(".:invite_page_content_button").click(by_js=True)
        tab.ele("#loginWithEmailWrapper").click(by_js=True)
        tab.ele("#createAccount").click(by_js=True)
        tab.ele("#email").input(mail.get_email())
        tab.ele(".:sendCode").click(by_js=True)
        code = mail.get_verification_code()
        if not code:
            raise FailedVerificationCode("Failed to get verification code")
        tab.ele("#emailVerificationCode").input(code)
        tab.ele(".:verifyCode").click(by_js=True)
        tab.ele("#newPassword").input(password)
        tab.ele("#reenterPassword").input(password)
        tab.ele("#continue").click(by_js=True)
        number = "+1 408 678 " + "".join(random.choices(string.digits, k=4)) + "\n"
        print(number)
        tab.ele(".vue-tel-input").click()
        tab.ele(".vue-tel-input").input(number, clear=True, by_js=False)
        tab.listen.start("sms_send_verification")
        tab.ele(".:verification_code_form").child(index=-1).click(by_js=True)
        res = tab.listen.wait()

        code = res.response.body["code"]
        tab.ele("#verification_code").input(code)
        tab.ele(".:claim_membership_benefits_button").child(index=0).click(by_js=True)
        time.sleep(2)
    except Exception as e:
        raise e
    finally:
        browser.quit(force=True)


if __name__ == "__main__":
    for _ in range(20):
        try:
            access_genspark()
        except FailedVerificationCode as e:
            print(e)
            continue
        except Exception as e:
            print(e)
