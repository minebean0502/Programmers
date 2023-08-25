def solution(arr, queries):
    for i in queries :
        for k in range(i[0],i[1]+1):
            arr[k] +=1
    return arr