def solution(s1, s2):
    answer = 0
    for i in s2:
        if i in s1:
            answer +=1
    return answer