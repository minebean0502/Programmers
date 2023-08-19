def solution(a, b, c, d):
    s1 = [a,b,c,d]
    x = min(s1)
    y = max(s1)
    B = 1
    C = s1.count(min(s1))
    D = s1.count(max(s1))
    if len(set(s1)) == 1:
        return 1111 * a
    elif len(set(s1)) == 2:
        if C == 1 and D == 3:
            return (10*y+x)*(10*y+x)
        elif C == 3 and D == 1:
            return (10*x+y)*(10*x+y)
        else : return (x+y) * abs(x-y)
    elif len(set(s1)) == 3:
        for i in s1:
            if s1.count(i) == 1:
                B *= i
        return B
    elif len(set(s1)) == 4:
        return min(s1)
