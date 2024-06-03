# Write a python program that will accept a word from the user. 
# The program will swap the first and the last character of the word.
# The First character of the resulting string must be an upper case while the last character of the resulting string must be a lower case character.

word = input("Enter a word :")
temp = word
temp[0] = word[len(word) -1]
temp[0].upper()
temp[len(temp) -1] = word[0]
temp[-1].lower()
print(temp)
