package com.project1.demo.payload;

import com.project1.demo.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;

public class S42Response {
    private Page<User> dataUser;
    private int currentPage;
    private int currentSize;
    private ModelMap model;

    public S42Response(Page<User> dataUser, int currentPage, int currentSize, ModelMap model) {
        this.dataUser = dataUser;
        this.currentPage = currentPage;
        this.currentSize = currentSize;
        this.model = model;
    }

    public Page<User> getDataUser() {
        return dataUser;
    }

    public void setDataUser(Page<User> dataUser) {
        this.dataUser = dataUser;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public ModelMap getModel() {
        return model;
    }

    public void setModel(ModelMap model) {
        this.model = model;
    }
}
