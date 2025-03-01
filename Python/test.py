from itertools import permutations

def find_expressions(n):
    results = []
    digits = '0123456789'
    
    for perm in permutations(digits):
        # 将前5位和后5位分别组成数字
        abcde = int(''.join(perm[:5]))
        fghij = int(''.join(perm[5:]))
        
        # 防止fghij为0
        if fghij != 0 and abcde / fghij == n:
            results.append(f"{abcde:05d} / {fghij:05d} = {n}")
    
    # 输出结果
    if results:
        for result in sorted(results):
            print(result)
    else:
        print("no answer")

# 输入与输出部分
try:
    while True:
        n = int(input().strip())
        if 2 <= n <= 79:
            find_expressions(n)
except EOFError:
    pass
