package com.example.imtihon_6.component;


import com.example.imtihon_6.entity.Role;
import com.example.imtihon_6.entity.User;

import com.example.imtihon_6.entity.enums.PermissionEnum;
import com.example.imtihon_6.entity.enums.RoleEnum;
import com.example.imtihon_6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    final PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("marco");
        user.setPassword(passwordEncoder.encode("7677976"));
        Role student = new Role( RoleEnum.ROLE_USER);
        List <PermissionEnum> permissionEnums = new ArrayList<>();
        permissionEnums.add(PermissionEnum.READ_BOOK);
        student.setPermissionEnum(permissionEnums);
        permissionEnums.clear();
        PermissionEnum[] enums = PermissionEnum.values();
        for (int i = 0; i < enums.length-1; i++) {
            permissionEnums.add(enums[i]);
        }

        Role admin = new Role( RoleEnum.ROLE_ADMIN);
        admin.setPermissionEnum(permissionEnums);
        Set<Role> roleSet = new LinkedHashSet<>();
        roleSet.add(student);
        roleSet.add(admin);
        user.setRoleSet(roleSet);
        userRepository.save(user);




    }
}
