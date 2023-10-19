import hashlib

num = 1
prefix = "yzbqklnj"
target_prefix = "0000000"

while True:
    input_str = f"{prefix}{num}".encode()
    md5_hash = hashlib.md5(input_str).hexdigest()

    if md5_hash[:7] == target_prefix:
        print(num)
        print(hashlib.md5(input_str).hexdigest())
        break

    num += 1