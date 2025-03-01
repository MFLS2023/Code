
class Student:
    def __init__(self, name, age):
        self.__name = name
        self.__age = age
        self.__grades = []

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, name):
        if len(name) > 20:
            print(" ")
        self.__name = name

    @property
    def age(self):
        return self.__age

    @age.setter
    def age(self, age):
        if not 6 <= age <= 100:
            print(" ")
        self.__age = age

    def add_grade(self, grade):
        if not 0 <= grade <= 100:
            print(" ")
        self.__grades.append(grade)

    def get_average_grade(self):
        if not self.__grades:
            return 0
        return sum(self.__grades) / len(self.__grades)


if __name__ == '__main__':
    student = Student(" asfdsafsdfafsfsf", 18)
    student.add_grade(90)
    student.add_grade(80)
    print(student.get_average_grade())