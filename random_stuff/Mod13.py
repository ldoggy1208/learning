import string

def rot13(text):
    alphabet = string.ascii_lowercase
    trans = str.maketrans(alphabet + alphabet.upper(), alphabet[13:] + alphabet[:13] + alphabet[13:].upper() + alphabet[:13].upper())
    
    return text.translate(trans)

message = "cvpbPGS{arkg_gvzr_V'yy_gel_2_ebhaqf_bs_ebg13_uJdSftmh}"
encrypted = rot13(message)
decrypted = rot13(encrypted)

print("Original:", message)
print("Encrypted:", encrypted)
print("Decrypted:", decrypted)