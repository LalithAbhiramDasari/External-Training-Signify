package com.example.BuildathonDay6.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BuildathonDay6.Models.Member;
import com.example.BuildathonDay6.Repository.MemberRepository;

@RestController

public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/GymRegister")
    public ResponseEntity<Map<String, String>> registerMember(@RequestBody Member member) 
    {
    	Member mem = memberRepository.save(member);
    	Map<String, String> response = new HashMap<>();
		response.put("Status", "Member Added");
		return ResponseEntity.ok(response);

    }

    @GetMapping("/activeMembers")
    public List<Member> getActiveMembers() {
        return memberRepository.findByActiveStatusTrue();
    }
}
