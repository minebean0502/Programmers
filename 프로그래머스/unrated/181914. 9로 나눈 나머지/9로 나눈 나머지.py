def solution(number):
    A = 0
    for i in number:
        A += eval(i)
    return A%9