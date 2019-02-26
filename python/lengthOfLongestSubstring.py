class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0

        i, j = 0, 0
        maxLen = 0
        sub = set()

        while i < len(s) and j < len(s):
            char = s[j]
            if char not in sub:
                sub.add(char)
                j += 1
                maxLen = max(maxLen, j-i)
            else:
                sub.remove(s[i])
                i += 1
        return maxLen
            


s = Solution()

length = s.lengthOfLongestSubstring('pwwkew')
print(length)