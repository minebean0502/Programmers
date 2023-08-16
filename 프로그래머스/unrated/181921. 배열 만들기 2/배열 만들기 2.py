def solution(l, r):
    answer = []
    for i in range(l, r+1):
        num_str = str(i)
        if '1' in num_str or '2' in num_str or '3' in num_str or '4' in num_str or '6' in num_str or '7' in num_str or '8' in num_str or '9' in num_str:
            continue
        else: answer.append(i)
    if len(answer)==0:
        return [-1]
    return answer