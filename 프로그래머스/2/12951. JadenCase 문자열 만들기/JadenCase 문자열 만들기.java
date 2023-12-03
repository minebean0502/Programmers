class Solution {
        public static String solution(String s) {
        String answer = "";
        String words[] = s.split("");
    
        if (words[0].equals(" ")) {
            answer += " ";
        } else answer += words[0].toUpperCase();
 
        for (int i = 1 ; i < words.length; i++) {
            if (words[i-1].equals(" ")) {
                answer += words[i].toUpperCase();
            }
            else answer += words[i].toLowerCase();
        }
        return answer;
    }
}    

//     public String solution(String s) {
//         String answer = "";
//         String words[] = s.split(" ");

//         if (words[0] != "") {
//             answer += words[0].toUpperCase().substring(0, 1) + words[0].toLowerCase().substring(1);
//         }

//         for (int i = 1; i < words.length; i++) {
//             if (words[i] == "") {
//                 answer += " ";
//             }else {
//                 answer += " " + words[i].toUpperCase().substring(0,1) + words[i].toLowerCase().substring(1);
//             }
//         }
//         return answer;
//     }
// }
