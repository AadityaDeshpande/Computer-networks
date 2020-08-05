import socket
s = socket.socket()

s.bind(('localhost',9999))

s.listen(3)

c,add = s.accept()

while True:
    print(c.recv(1024).decode())
    user = input('S>> ')
    c.send(bytes(user,"utf-8"))
