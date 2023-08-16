def solution(arr, idx):
    answer = 0
    if 1 in arr[idx:]:
        for i in range(len(arr)):
            if arr[i] == 1 and i>=idx:
                return i
    else : return -1