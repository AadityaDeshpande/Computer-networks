import socket
c = socket.socket()

c.connect(('localhost',9999))

while True:
    user = input("C>> ")
    c.send(bytes(user,"utf-8"))
    print(c.recv(1024).decode())
    