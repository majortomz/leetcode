package main

import (
	"fmt"
)

type User struct {
	A
	B
}

type A struct {

}

type B struct {

}

func (u *B) SayHello(name string) {
	fmt.Println("hello B,", name)
}

func (u *A) SayHello(name string) {
	fmt.Println("hello B,", name)
}

func main() {

	u := User{}
	u.SayHello("tom")

	fmt.Println("hello world!")
}
