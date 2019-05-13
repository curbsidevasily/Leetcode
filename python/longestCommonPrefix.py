from typing import List


class Solution1:
    def get_common_prefix(self, prefix, s):
        l = min(len(prefix), len(s))
        for k in range(l):
            if prefix[k] != s[k]:
                if k == 0:
                    return ''
                else:
                    return prefix[:k]
        return prefix[:l]

    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ''

        if len(strs) == 1:
            return strs[0]

        prefix = strs[0]

        for s in strs[1:]:
            prefix = self.get_common_prefix(prefix, s)
            if not prefix or len(prefix) == 0:
                break

        return prefix


class Solution2:
    """vertical scanning"""

    def get_common_prefix(self, prefix, s):
        l = min(len(prefix), len(s))
        for k in range(l):
            if prefix[k] != s[k]:
                if k == 0:
                    return ''
                else:
                    return prefix[:k]
        return prefix[:l]

    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ''

        if len(strs) == 1:
            return strs[0]

        prefix = strs[0]
        for k in range(len(prefix)):
            for s in strs[1:]:
                if k >= len(s) or prefix[k] != s[k]:
                    return prefix[:k]
        return prefix


test = ["flower", "flow", "flight"]
s = Solution2()
res = s.longestCommonPrefix(test)
print(res)
