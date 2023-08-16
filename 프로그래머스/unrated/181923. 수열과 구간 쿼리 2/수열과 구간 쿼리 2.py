def solution(arr, queries):
    A = []
    B = []
    for i, (s,e,k) in enumerate(queries):
        for j in arr[s:e+1]:
            if j > k:
                A.append(j)
        if len(A) == 0 :
            B.append(-1)
            A.clear()
        elif len(A) >= 1:
            B.append(min(A))
            A.clear()
    return B
   