Renzo and the Palindromic Decoration
At the ruins of Wat Phra Si Sanphet (วัดพระศรีสรรเพชญ์), one can find famous inscriptions that have only recently been decoded. Several numbers written using Thai numerals decorate these ruins.

A couple of years ago, the famous Peruvian researcher Renzo "elintrépido" Morales found out that most numbers found at the ruins are palindromic, that is, they represent the same number when read backwards. For instance, 171 is palindromic, whereas 17 is not.

Intrigued by the existence of non palidromic numbers as decorations in the ruins, Renzo found out that, while these numbers are not palindromic when represented in base 10 (which is the base used in the Thai numeral system), they are palindromic when represented in another base. For b > 0, the base-b representation of a number N is the sequence amam-1...a1a0 so that 0 ≤ ai ≤ b-1 for each 0 ≤ i ≤ m, am > 0, and ambm+ am-1bm-1+ ... + a1b + a0 = N. For the previous example, the base-2 representation of 17 is 10001, which is palindromic.

To validate his discovery, Renzo wants you to write a program that takes a number represented in base 10 and checks in which bases from 2 to 16 such number has a palindromic representation.

Input
The input contains several instances. The first line of the input has an integer T corresponding to the number of instances.

Each instance has a single line with an integer N (0 ≤ N < 231) written in base 10.

Output
For each instance, print in a single line a space-separated list of integers, from 2 to 16 and in increasing order, of the bases for which the representation of N is palindromic. If N does not have a palindromic representation for any of the bases from 2 to 16, print -1.