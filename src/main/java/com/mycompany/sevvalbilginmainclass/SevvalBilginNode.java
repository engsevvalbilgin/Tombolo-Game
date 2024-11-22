/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sevvalbilginmainclass;

/**
 *
 * @author hp
 */
public class SevvalBilginNode<T>{
    public enum Sign{plus,minus}
    T data;
    Sign sign;
    SevvalBilginNode<T> next;
    SevvalBilginNode<T> prev;
    SevvalBilginNode<T> up;
    SevvalBilginNode<T> down;
    public SevvalBilginNode(T data){
    this.sign=Sign.plus;
    this.data=data;
    this.next=null;
    this.prev=null;
    this.up=null;
    this.down=null;
    }
    public SevvalBilginNode(){
    this.sign=Sign.plus;
    this.data=null;
    this.next=null;
    this.prev=null;
    this.up=null;
    this.down=null;
    }
    
}
