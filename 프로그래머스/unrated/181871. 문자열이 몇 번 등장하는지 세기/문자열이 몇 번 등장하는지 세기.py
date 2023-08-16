def solution(myString, pat):
    answer = 0
    P = len(pat)
    Q = len(myString)
    for i in range(Q-P+1):
        if pat in myString[i:P+i]:
            answer += 1
    return answer