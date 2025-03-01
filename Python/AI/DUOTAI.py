
def draw_circle(radius):
    print(f"Drawing a circle with radius {radius}")

def draw_rectangle(length, width):
    print(f"Drawing a rectangle with length {length} and width {width}")

def draw_triangle(base, height):
    print(f"Drawing a triangle with base {base} and height {height}")


shape_functions = {
    "circle": draw_circle,
    "rectangle": draw_rectangle,
    "triangle": draw_triangle
}

# 按要求传入参数并循环调用函数
for shape_name, func in shape_functions.items():
    if shape_name == "circle":
        func(3)
    elif shape_name == "rectangle":
        func(4, 5)
    elif shape_name == "triangle":
        func(6, 7)