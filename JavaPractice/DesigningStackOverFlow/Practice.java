package JavaPractice.DesigningStackOverFlow;

public class Practice {
    static void main() {
        // Create UserA
        // UserA will create Post1
        // Create another userB
        // UserB will Upvote post1
        // Create another USer userC
        // UserC will upvote post1
        // userA Reputation increased by 2 according to Upvote by userB and UserC
        // CreateUserD
        // UserD Downvote Post1
        // UserD answer the Post1
        // USerC comment in the Post1
        // UserB comment in the UserD answer and Upvote it
        // userA Reputation decreased by 1 and its Current reputation is 1

        // Entity
        // User, Post,
        // post is a Question, Answer, Comment
        // Question has postId, content, tag, createdId, Upvote and devote
        // Answer has postId, content, tag, createdId, Upvote and devote
        // Comment has postId, content,

        // User has userName, userId, reputation

        //services
        // Search Service
        // Search by Keyword, tag and userId

        // Interface Method for the StackOerFlowService
        // CreateQuestionPost (userid, content, tag)
        // CreateAnswerPost(userid, postId, answerContent)
        // CreateComment(userid, postId, commentContent)
        // DeletePost(userid, postId)

        // Interface Voter
        // UpvotePost(postId)
        // downvote(postId)

        //Interface UserManager
        //UserCreation
        //UserDelete

    }
}
