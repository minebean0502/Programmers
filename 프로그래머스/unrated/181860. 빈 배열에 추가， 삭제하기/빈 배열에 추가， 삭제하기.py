def solution(arr, flag):
    true = True
    false = False
    answer = []
    for i in range(len(flag)):
        if flag[i] == True:
            for j in range(arr[i]*2):
                answer.append(arr[i])
        elif flag[i] == False:
            answer = answer[:-(arr[i])]
    return answer