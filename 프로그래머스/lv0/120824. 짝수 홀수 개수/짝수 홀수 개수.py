def solution(num_list):
    answer = [0, 0]
    for i in num_list:
        if i % 2 ==0:
            answer[0] += 1
        elif i % 2 ==1:
            answer[1] += 1
    return answer