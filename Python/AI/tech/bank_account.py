import sys
import json
from PyQt5.QtWidgets import QApplication, QWidget, QVBoxLayout, QHBoxLayout, QPushButton, QLineEdit, QLabel, QMessageBox, QTabWidget

class BankAccount:
    def __init__(self, name, balance, password):
        self.name = name
        self.balance = balance
        self.password = password

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            return True
        return False

    def withdraw(self, amount):
        if 0 < amount <= self.balance:
            self.balance -= amount
            return True
        return False

    def check_password(self, password):
        return self.password == password

class BankApp(QWidget):
    def __init__(self):
        super().__init__()
        self.accounts = {}
        self.current_account = None
        self.init_ui()

    def init_ui(self):
        self.setWindowTitle('银行账户管理系统')
        self.setGeometry(300, 300, 400, 300)

        layout = QVBoxLayout()

        self.tab_widget = QTabWidget()
        self.tab_widget.addTab(self.create_login_tab(), "登录")
        self.tab_widget.addTab(self.create_register_tab(), "注册")
        self.tab_widget.addTab(self.create_operation_tab(), "账户操作")
        layout.addWidget(self.tab_widget)

        self.setLayout(layout)

    def create_login_tab(self):
        login_widget = QWidget()
        login_layout = QVBoxLayout()

        self.name_input = QLineEdit(login_widget)
        self.name_input.setPlaceholderText('账户名')
        login_layout.addWidget(self.name_input)

        self.password_input = QLineEdit(login_widget)
        self.password_input.setPlaceholderText('密码')
        self.password_input.setEchoMode(QLineEdit.Password)
        login_layout.addWidget(self.password_input)

        self.login_btn = QPushButton('登录', login_widget)
        self.login_btn.clicked.connect(self.login)
        login_layout.addWidget(self.login_btn)

        login_widget.setLayout(login_layout)
        return login_widget

    def create_register_tab(self):
        register_widget = QWidget()
        register_layout = QVBoxLayout()

        self.new_name_input = QLineEdit(register_widget)
        self.new_name_input.setPlaceholderText('新账户名')
        register_layout.addWidget(self.new_name_input)

        self.new_password_input = QLineEdit(register_widget)
        self.new_password_input.setPlaceholderText('新密码')
        self.new_password_input.setEchoMode(QLineEdit.Password)
        register_layout.addWidget(self.new_password_input)

        self.initial_balance_input = QLineEdit(register_widget)
        self.initial_balance_input.setPlaceholderText('初始余额')
        register_layout.addWidget(self.initial_balance_input)

        self.register_btn = QPushButton('创建账户', register_widget)
        self.register_btn.clicked.connect(self.register)
        register_layout.addWidget(self.register_btn)

        register_widget.setLayout(register_layout)
        return register_widget

    def create_operation_tab(self):
        operation_widget = QWidget()
        operation_layout = QVBoxLayout()

        self.amount_input = QLineEdit(operation_widget)
        self.amount_input.setPlaceholderText('金额')
        operation_layout.addWidget(self.amount_input)

        btn_layout = QHBoxLayout()
        self.deposit_btn = QPushButton('存款', operation_widget)
        self.deposit_btn.clicked.connect(self.deposit)
        btn_layout.addWidget(self.deposit_btn)

        self.withdraw_btn = QPushButton('取款', operation_widget)
        self.withdraw_btn.clicked.connect(self.withdraw)
        btn_layout.addWidget(self.withdraw_btn)

        self.show_btn = QPushButton('查看账户信息', operation_widget)
        self.show_btn.clicked.connect(self.show_account_info)
        btn_layout.addWidget(self.show_btn)

        operation_layout.addLayout(btn_layout)

        self.balance_label = QLabel('余额: ', operation_widget)
        operation_layout.addWidget(self.balance_label)

        operation_widget.setLayout(operation_layout)
        return operation_widget

    def login(self):
        name = self.name_input.text()
        password = self.password_input.text()
        if name in self.accounts and self.accounts[name].check_password(password):
            self.current_account = self.accounts[name]
            self.update_balance()
            QMessageBox.information(self, '登录成功', f'欢迎, {name}!')
            self.tab_widget.setCurrentIndex(2)  # 切换到操作页面
        else:
            QMessageBox.warning(self, '登录失败', '账户名或密码错误')

    def register(self):
        name = self.new_name_input.text()
        password = self.new_password_input.text()
        try:
            initial_balance = float(self.initial_balance_input.text())
        except ValueError:
            QMessageBox.warning(self, '错误', '请输入有效的初始余额')
            return

        if name in self.accounts:
            QMessageBox.warning(self, '错误', '账户名已存在')
        elif initial_balance < 0:
            QMessageBox.warning(self, '错误', '初始余额不能为负数')
        else:
            self.accounts[name] = BankAccount(name, initial_balance, password)
            QMessageBox.information(self, '成功', '账户创建成功')
            self.new_name_input.clear()
            self.new_password_input.clear()
            self.initial_balance_input.clear()

    def deposit(self):
        if not self.current_account:
            QMessageBox.warning(self, '错误', '请先登录')
            return
        try:
            amount = float(self.amount_input.text())
            if self.current_account.deposit(amount):
                self.update_balance()
                QMessageBox.information(self, '存款成功', f'已存入 {amount} 元')
            else:
                QMessageBox.warning(self, '存款失败', '请输入正确的金额')
        except ValueError:
            QMessageBox.warning(self, '错误', '请输入有效的金额')

    def withdraw(self):
        if not self.current_account:
            QMessageBox.warning(self, '错误', '请先登录')
            return
        try:
            amount = float(self.amount_input.text())
            if self.current_account.withdraw(amount):
                self.update_balance()
                QMessageBox.information(self, '取款成功', f'已取出 {amount} 元')
            else:
                QMessageBox.warning(self, '取款失败', '余额不足或金额无效')
        except ValueError:
            QMessageBox.warning(self, '错误', '请输入有效的金额')

    def show_account_info(self):
        if not self.current_account:
            QMessageBox.warning(self, '错误', '请先登录')
            return
        info = f"账户名: {self.current_account.name}\n"
        info += f"余额: {self.current_account.balance}\n"
        info += f"密码: {'*' * len(self.current_account.password)}"
        QMessageBox.information(self, '账户信息', info)

    def update_balance(self):
        if self.current_account:
            self.balance_label.setText(f'余额: {self.current_account.balance}')

if __name__ == '__main__':
    app = QApplication(sys.argv)
    bank_app = BankApp()
    bank_app.show()
    sys.exit(app.exec_())