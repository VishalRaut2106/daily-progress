class Solution:
    def uniquePerms(self, arr):
        res = []
        arr.sort()
        used = [False] * len(arr)
        
        def backtrack(path):
            if len(path) == len(arr):
                res.append(path[:])
                return
            
            for i in range(len(arr)):
                if used[i]:
                    continue
                # Skip duplicates
                if i > 0 and arr[i] == arr[i-1] and not used[i-1]:
                    continue
                
                used[i] = True
                path.append(arr[i])
                backtrack(path)
                path.pop()
                used[i] = False
        
        backtrack([])
        return res