def solution(array, n):
    answer = 0
    while True:
        if n in array:
            array.remove(n)
            answer += 1
        elif n not in array:
            return answer
            break