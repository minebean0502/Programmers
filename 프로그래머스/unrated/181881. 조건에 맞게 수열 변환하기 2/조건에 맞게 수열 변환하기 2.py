import copy
def solution(arr):
    answer = []
    j = 0
    while True:
        answer = copy.deepcopy(arr)
        for i in range(len(arr)):
            if arr[i] > 50 and arr[i] % 2 == 0:
                arr[i] = arr[i] //2 
            elif arr[i] < 50 and arr[i] % 2 == 1:
                arr[i] = arr[i] * 2 + 1
        if answer == arr:
            return j
        j += 1
        