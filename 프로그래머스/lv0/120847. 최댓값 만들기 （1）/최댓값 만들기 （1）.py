def solution(numbers):
    answer = 0
    numbers.sort()
    answer += numbers.pop()
    return answer * numbers.pop()