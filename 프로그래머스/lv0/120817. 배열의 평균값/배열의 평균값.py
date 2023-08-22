def solution(numbers):
    x = 0
    for i in numbers:
        x += i
    return x/len(numbers)