class BankAccount:
    def __init__(self, initial_balance=0):
        # 初始化账户余额
        self.balance = initial_balance

    def deposit(self, amount):
        # 存款功能，增加账户余额
        if amount > 0:
            self.balance += amount
            print(f"存款成功，您的账户余额为：{self.balance}")
        else:
            print("存款金额必须大于零。")

    def withdraw(self, amount):
        # 取款功能，检查余额是否足够
        if amount <= 0:
            print("取款金额必须大于零。")
        elif amount > self.balance:
            print("余额不足，无法完成取款操作。")
        else:
            self.balance -= amount
            print(f"取款成功，您的账户余额为：{self.balance}")

    def get_balance(self):
        # 查询余额
        return self.balance

# 主程序
def main():
    # 创建账户实例，初始余额为100
    account = BankAccount(100)

    while True:
        print("\n请选择操作：")
        print("1. 查询余额")
        print("2. 存款")
        print("3. 取款")
        print("4. 退出")
        choice = input("请输入选项（1/2/3/4）：")

        if choice == "1":
            print(f"您的账户余额为：{account.get_balance()}")
        elif choice == "2":
            amount = float(input("请输入存款金额："))
            account.deposit(amount)
        elif choice == "3":
            amount = float(input("请输入取款金额："))
            account.withdraw(amount)
        elif choice == "4":
            print("谢谢使用，再见！")
            break
        else:
            print("无效选项，请重新输入。")

if __name__ == "__main__":
    main()
