package com.reto3.com.reto3.CreacionHoteles.Service;

import com.reto3.Repository.AdminRepository;
import com.reto3.com.reto3.CreacionHoteles.modelo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin>getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    public Admin save(Admin admin){
        if(admin.getId() == null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> aux = adminRepository.getAdmin(admin.getId());
            if (aux.isPresent()){
                return admin;
            }else{
                return adminRepository.save(admin);
            }
        }
    }
    public Admin update(Admin admin){
        if (admin.getId() != null){
            Optional<Admin> c = adminRepository.getAdmin(admin.getId());
            if(c.isPresent()){
                if (admin.getName() != null){
                    c.get().setName(admin.getName());
                }
                if(admin.getPassword() != null){
                    c.get().setPassword(admin.getPassword());
                }
                if(admin.getEmail() != null){
                    c.get().setEmail(admin.getEmail());
                }
                adminRepository.save(c.get());
                return c.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Admin> c = adminRepository.getAdmin(id);
        if (c.isPresent()){
            adminRepository.delete(c.get());
        }
        return flag;
    }
}