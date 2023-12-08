A, B = map(int, input().split())
C = int(input())
if B+C >=60:
    A = int(A+(B+C)//60)
    B = int((B+C)%60)
    if A>=24:
        A=int(A-24)
        print(A, B)
    else:
        print(A, B)
else:
    print(A, int(B+C))