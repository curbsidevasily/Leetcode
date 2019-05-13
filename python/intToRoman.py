class IntToRoman:
    def devide(self, num, n):
        return int(num // n), num % n

    def intToRoman(self, num: int) -> str:
        chars = ['I', 'V', 'X', 'L', 'C', 'D', 'M']
        i = len(chars) - 1
        v_i = 1000

        romans = []

        while (num > 0):
            m, res = self.devide(num, v_i)

            v_i /= 10
            if m == 0:
                i -= 2
                continue

            elif m < 4:
                romans.extend([chars[i]] * m)
            elif m == 4:
                romans.extend([chars[i], chars[i + 1]])
            elif m < 9:
                romans.extend([chars[i + 1]] + [chars[i] * (m - 5)])
            else:
                romans.extend([chars[i], chars[i + 2]])

            num = res
            i -= 2

        return ''.join(romans)


s = IntToRoman()
num = 3999
print(s.intToRoman(num))
