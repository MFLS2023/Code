import smtplib
from email.mime.text import MIMEText

def send_email():
    # SMTP 配置信息
    smtp_server = "send.ahasend.com"
    smtp_port = 587
    smtp_user = "eqHOompwP1"
    smtp_password = "W9jwUmsR1Dxers5eNjKwBAzQ"

    # 邮件内容配置
    from_email = "your-email@example.com"  # 替换为您的发件人邮箱
    to_email = "recipient@example.com"     # 替换为收件人邮箱
    subject = "Test Email from AhaSend SMTP"
    body = "Hello, this is a test email sent using AhaSend SMTP configuration."

    # 构造邮件
    msg = MIMEText(body)
    msg['From'] = from_email
    msg['To'] = to_email
    msg['Subject'] = subject

    try:
        # 连接到 SMTP 服务器
        server = smtplib.SMTP(smtp_server, smtp_port)
        server.set_debuglevel(1)  # 打开调试信息
        server.starttls()  # 启用 TLS 加密
        server.login(smtp_user, smtp_password)
        server.sendmail(from_email, to_email, msg.as_string())
        print("Email sent successfully!")
    except Exception as e:
        print(f"Failed to send email: {e}")
    finally:
        server.quit()

send_email()
