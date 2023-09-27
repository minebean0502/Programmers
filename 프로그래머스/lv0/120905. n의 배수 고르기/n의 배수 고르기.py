def solution(n, numlist):
    answer =[]
    for k in numlist:
        if k % n == 0:
            answer += [k]
    return answer