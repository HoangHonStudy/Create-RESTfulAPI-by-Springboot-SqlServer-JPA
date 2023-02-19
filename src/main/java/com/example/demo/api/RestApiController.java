package com.example.demo.api;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     // Trả về dữ liệu dưới dạng JSON
@RequestMapping("/api")   // Nhận tất cả method request tới "/api" và map cho class RestApiController
public class RestApiController {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired      //Inject tự động bean UsersService
    UsersService usersService;

    /**
     * Nhận GET request tới "/user/" và map cho method listAllUsers.
     * lấy tất cả người dùng.
     * @return  Danh sách tất cả Users mới trong database
     */
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> listAllUsers() {
        List<Users> listUsers = usersService.findAll();
        if(listUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Users>>(listUsers, HttpStatus.OK);
    }

    /**
     * Nhận GET request tới "/user/{id}" và map cho method findUsers.
     * lấy một người dùng
     * @param id    lấy một người dùng
     * @return  một User trong database theo id
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Users findUser(@PathVariable(value = "id") int id) {
        Users users = usersService.findById(id).get();
        if (users == null) {
            ResponseEntity.notFound().build();
        }

        return users;
    }

    /**
     * Nhận POST request tới "/user/" và map cho method saveUsers.
     * Tạo người dùng mới.
     * @param users    Chuyển chuỗi JSON trong request thành Users.
     * @return  một User sau khi save
     */
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public Users saveUser(@RequestBody Users users) {
        return usersService.save(users);
    }

    /**
     * Nhận POST request tới "/user/{id}" và map cho method updateUsers.
     * update người dùng.
     * @param id    lấy một người dùng.
     * @param userForm      Chuyển chuỗi JSON trong request thành Users.
     * @return  một user trong database đã được update.
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") int id, @RequestBody Users userForm) {
        Users users = usersService.findById(id).get();
        if(users == null) {
            return ResponseEntity.notFound().build();
        }
        users.setName(userForm.getName());
        users.setAddress(userForm.getAddress());
        users.setEmail(userForm.getEmail());
        users.setPhone(userForm.getPhone());

        Users updatedUser = usersService.save(users);

        return  ResponseEntity.ok(updatedUser);
    }

    /**
     * Nhận DELETE request tới "/user/{id}" và map cho method deleteUsers.
     * Xóa người dùng.
     * @param id    Lấy ra thông tin id trong URL.
     * @return  Trạng thái ok
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteUser(@PathVariable(value = "id") int id) {
        Users users = usersService.findById(id).get();
        if(users == null) {
            return ResponseEntity.notFound().build();
        }

        usersService.delete(users);
        return ResponseEntity.ok().build();
    }
}


