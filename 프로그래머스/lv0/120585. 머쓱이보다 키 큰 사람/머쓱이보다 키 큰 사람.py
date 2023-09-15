def solution(array, height):
    answer = 0
    for i in array:
        if i - height >0:
            answer += 1
    return answer