def solution(my_string):
    answer = []
    i = 0
    while i <= 25:
        answer.append(my_string.count(chr(65+i)))
        i += 1
    while i <= 51:
        answer.append(my_string.count(chr(71+i)))
        i += 1
    return answer