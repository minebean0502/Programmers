def solution(num_list):
    answer = 0
    idx = 0
    while idx <= len(num_list):   
        if idx == len(num_list):
            return answer
            break
        elif num_list[idx] == 1:
            idx += 1
        elif num_list[idx] % 2 ==0:
            num_list[idx] = num_list[idx]//2
            answer += 1
        elif num_list[idx] % 2 ==1:
            num_list[idx] = (num_list[idx]-1)//2
            answer += 1