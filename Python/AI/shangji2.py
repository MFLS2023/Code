class Student:
    """
    学生类，包含学生的姓名、年龄和成绩。
    """

    def __init__(self, name, age, *scores):
        """
        初始化学生对象。

        :param name: 学生的姓名
        :param age: 学生的年龄
        :param scores: 学生的成绩（可以是多个）
        """
        self.name = name
        self.age = age
        self.scores = scores

    def get_name(self):
        """
        获取学生的姓名。

        :return: 学生的姓名
        """
        return self.name

    def get_age(self):
        """
        获取学生的年龄。

        :return: 学生的年龄
        """
        return self.age

    def get_highest_score(self):
        """
        获取学生的最高成绩。

        :return: 学生的最高成绩
        """
        return max(self.scores)


# 测试代码
if __name__ == "__main__":
    # 创建一个学生对象，并传入姓名、年龄和成绩
    student1 = Student("Alice", 20, 85, 90, 78, 95)

    # 测试 get_name 方法
    assert student1.get_name() == "Alice", "get_name 方法测试失败"
    print("get_name 方法测试通过")

    # 测试 get_age 方法
    assert student1.get_age() == 20, "get_age 方法测试失败"
    print("get_age 方法测试通过")

    # 测试 get_highest_score 方法
    assert student1.get_highest_score() == 95, "get_highest_score 方法测试失败"
    print("get_highest_score 方法测试通过")

    # 创建另一个学生对象，测试不同情况
    student2 = Student("Bob", 22, 60, 70, 80)

    # 测试 get_name 方法
    assert student2.get_name() == "Bob", "get_name 方法测试失败"
    print("get_name 方法测试通过")

    # 测试 get_age 方法
    assert student2.get_age() == 22, "get_age 方法测试失败"
    print("get_age 方法测试通过")

    # 测试 get_highest_score 方法
    assert student2.get_highest_score() == 80, "get_highest_score 方法测试失败"
    print("get_highest_score 方法测试通过")

    print("所有学生类测试通过！")


import math

class Rect:
    """
    矩形类，包含长度和宽度。
    """

    def __init__(self, length=20, width=10):
        """
        初始化矩形对象。

        :param length: 矩形的长度，默认为20
        :param width: 矩形的宽度，默认为10
        """
        self.length = length
        self.width = width

    def perimeter(self):
        """
        计算矩形的周长。

        :return: 矩形的周长
        """
        return 2 * (self.length + self.width)

    def area(self):
        """
        计算矩形的面积。

        :return: 矩形的面积
        """
        return self.length * self.width


class Square:
    """
    正方形类，包含边长。
    """

    def __init__(self, side=10):
        """
        初始化正方形对象。

        :param side: 正方形的边长，默认为10
        """
        self.side = side

    def perimeter(self):
        """
        计算正方形的周长。

        :return: 正方形的周长
        """
        return 4 * self.side

    def area(self):
        """
        计算正方形的面积。

        :return: 正方形的面积
        """
        return self.side * self.side


class Circle:
    """
    圆形类，包含半径。
    """

    def __init__(self, radius=10):
        """
        初始化圆形对象。

        :param radius: 圆的半径，默认为10
        """
        self.radius = radius

    def circlezc(self):
        """
        计算圆的周长。

        :return: 圆的周长
        """
        return 2 * math.pi * self.radius

    def circlemj(self):
        """
        计算圆的面积。

        :return: 圆的面积
        """
        return math.pi * self.radius ** 2


class Ball:
    """
    球类，包含半径。
    """

    def __init__(self, radius=10):
        """
        初始化球对象。

        :param radius: 球的半径，默认为10
        """
        self.radius = radius

    def ballbmj(self):
        """
        计算球的表面积。

        :return: 球的表面积
        """
        return 4 * math.pi * self.radius ** 2

    def balltj(self):
        """
        计算球的体积。

        :return: 球的体积
        """
        return (4 / 3) * math.pi * self.radius ** 3


# 测试代码
if __name__ == "__main__":
    print("开始测试 Rect 类：")
    rect = Rect(length=25, width=15)
    print(f"矩形的长度: {rect.length}")
    print(f"矩形的宽度: {rect.width}")
    print(f"矩形的周长: {rect.perimeter()}")
    print(f"矩形的面积: {rect.area()}")
    print()

    print("开始测试 Square 类：")
    square = Square(side=12)
    print(f"正方形的边长: {square.side}")
    print(f"正方形的周长: {square.perimeter()}")
    print(f"正方形的面积: {square.area()}")
    print()

    print("开始测试 Circle 类：")
    circle = Circle(radius=7)
    print(f"圆的半径: {circle.radius}")
    print(f"圆的周长: {circle.circlezc()}")
    print(f"圆的面积: {circle.circlemj()}")
    print()

    print("开始测试 Ball 类：")
    ball = Ball(radius=5)
    print(f"球的半径: {ball.radius}")
    print(f"球的表面积: {ball.ballbmj()}")
    print(f"球的体积: {ball.balltj()}")
    print()

    print("所有测试完成！")