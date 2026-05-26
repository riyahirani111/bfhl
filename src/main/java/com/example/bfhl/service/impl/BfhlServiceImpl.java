package com.example.bfhl.service.impl;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import com.example.bfhl.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDto process(RequestDto requestDto) {

        List<String> odd = new ArrayList<>();
        List<String> even = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> special = new ArrayList<>();

        int sum = 0;

        StringBuilder sb = new StringBuilder();

        for (String item : requestDto.getData()) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0) {
                    even.add(item);
                } else {
                    odd.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                sb.append(item);

            } else {

                special.add(item);
            }
        }

        String reversed = sb.reverse().toString();

        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            if (i % 2 == 0) {
                finalString.append(
                        Character.toUpperCase(reversed.charAt(i))
                );
            } else {
                finalString.append(
                        Character.toLowerCase(reversed.charAt(i))
                );
            }
        }

        return ResponseDto.builder()
                .is_success(true)
                .user_id("riya_hirani_08092005")
                .email("riyahirani230844@acropolis.in")
                .roll_number("0827CI231111")
                .odd_numbers(odd)
                .even_numbers(even)
                .alphabets(alphabets)
                .special_characters(special)
                .sum(String.valueOf(sum))
                .concat_string(finalString.toString())
                .build();
    }
}