class Solution:
    def findPeakGrid(self, mat):
        # code here
        row=len(mat)
        col=len(mat[0])
        c=0
        r=0
        while True:
            if r+1<row and mat[r][c]<mat[r+1][c]:
                r+=1
                continue
            
            if c+1<col and mat[r][c]<mat[r][c+1]:
                c+=1
                continue
            
            if r-1>-1 and mat[r][c]<mat[r-1][c]:
                r-=1
                continue
            
            if c-1>-1 and mat[r][c]<mat[r][c-1]:
                c-=1
                continue
            break
        return [r,c]