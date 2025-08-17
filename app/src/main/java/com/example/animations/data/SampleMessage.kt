package com.example.animations.data

import com.example.animations.model.Message


val sampleMessages = listOf(
    Message("Alice", "Hey, are we still meeting at 5 PM near the cafe?", "2025-08-15 09:32", false),
    Message("Bob", "Yeah, I’ll be there. Should I bring the laptop?", "2025-08-15 09:35", true),
    Message(
        "Alice",
        "Yes please, I want to show you the designs I made last night.",
        "2025-08-15 09:36",
        false
    ),
    Message(
        "Charlie",
        "Hey guys, I might be late. Traffic is crazy here.",
        "2025-08-15 09:40",
        false
    ),
    Message("Bob", "No worries, we can start once you’re here.", "2025-08-15 09:41", true),
    Message(
        "Alice",
        "Also, have you seen the new update on the project tracker?",
        "2025-08-15 09:45",
        false
    ),
    Message("Bob", "Not yet, I’ll check it after the meeting.", "2025-08-15 09:46", true),
    Message(
        "Charlie",
        "I just checked, the client has added some new requirements.",
        "2025-08-15 09:47",
        false
    ),
    Message("Alice", "Oh no, hope it’s nothing major.", "2025-08-15 09:48", false),
    Message(
        "Charlie",
        "It’s mostly UI changes, but there’s a deadline shift too.",
        "2025-08-15 09:49",
        false
    ),
    Message("Bob", "Deadline shift? Is it extended or reduced?", "2025-08-15 09:50", true),
    Message(
        "Charlie",
        "Extended by two weeks. Gives us some breathing space.",
        "2025-08-15 09:51",
        false
    ),
    Message("Alice", "That’s good news actually.", "2025-08-15 09:52", false),
    Message(
        "Bob",
        "Agreed. By the way, did anyone bring the HDMI cable?",
        "2025-08-15 09:53",
        true
    ),
    Message(
        "Charlie",
        "Oops, I forgot. Can we borrow one from the office?",
        "2025-08-15 09:54",
        false
    ),
    Message("Alice", "Yes, I’ll ask at the reception.", "2025-08-15 09:55", false),
    Message("Bob", "Cool, thanks!", "2025-08-15 09:56", true),
    Message("Alice", "No problem.", "2025-08-15 09:57", false),
    Message("Charlie", "I’ll be there in 15 mins, stuck at a signal.", "2025-08-15 09:58", false),
    Message("Bob", "Alright, drive safe.", "2025-08-15 09:59", true),
    Message(
        "Alice",
        "While we wait, should we review the presentation?",
        "2025-08-15 10:00",
        false
    ),
    Message("Bob", "Yeah, open it on your screen.", "2025-08-15 10:01", true),
    Message("Alice", "Okay, loading it now.", "2025-08-15 10:02", false),
    Message("Charlie", "Just passed the bridge, almost there.", "2025-08-15 10:03", false),
    Message("Bob", "Perfect timing.", "2025-08-15 10:04", true),
    Message(
        "Alice",
        "So about slide 5, I think we need a better image.",
        "2025-08-15 10:05",
        false
    ),
    Message("Bob", "Yeah, the current one looks pixelated.", "2025-08-15 10:06", true),
    Message(
        "Charlie",
        "I can replace it with a high-res version tonight.",
        "2025-08-15 10:07",
        false
    ),
    Message("Alice", "Thanks, that’d be great.", "2025-08-15 10:08", false),
    Message("Bob", "We also need to update the timeline chart.", "2025-08-15 10:09", true),
    Message("Charlie", "I can handle that as well.", "2025-08-15 10:10", false),
    Message("Alice", "Teamwork makes the dream work.", "2025-08-15 10:11", false),
    Message("Bob", "Haha, absolutely.", "2025-08-15 10:12", true),
    Message("Charlie", "I’m parking now, see you inside.", "2025-08-15 10:13", false),
    Message("Alice", "We’re at table 4.", "2025-08-15 10:14", false),
    Message("Bob", "Right next to the window.", "2025-08-15 10:15", true),
    Message("Charlie", "Got it. Also, I grabbed coffee for everyone.", "2025-08-15 10:16", false),
    Message("Alice", "You’re the best!", "2025-08-15 10:17", false),
    Message("Bob", "Yes, coffee saves lives.", "2025-08-15 10:18", true),
    Message("Charlie", "Okay, let’s get started with the meeting.", "2025-08-15 10:19", false),
    Message("Alice", "Agenda point 1: Review of last sprint.", "2025-08-15 10:20", false),
    Message("Bob", "We hit most targets, but testing took longer.", "2025-08-15 10:21", true),
    Message("Charlie", "We need to improve our test automation.", "2025-08-15 10:22", false),
    Message("Alice", "Agreed. I’ll work on a proposal for that.", "2025-08-15 10:23", false),
    Message("Bob", "Next, design feedback from the client.", "2025-08-15 10:24", true),
    Message(
        "Charlie",
        "They liked the clean layout but want more animations.",
        "2025-08-15 10:25",
        false
    ),
    Message("Alice", "More animations = more work for dev team.", "2025-08-15 10:26", false),
    Message("Bob", "We’ll prioritize them based on effort.", "2025-08-15 10:27", true),
    Message("Charlie", "Sounds fair.", "2025-08-15 10:28", false),

    Message(
        name = "Alice",
        originalContent = "Hey, how are you?",
        date = "12:30 PM",
        isSender = false
    ),
    Message(
        name = "You",
        originalContent = "I’m good! Just came back from the gym.",
        date = "12:31 PM",
        isSender = true
    ),
) + (1..50).map { index ->
    Message(
        name = if (index % 2 == 0) "You" else "Alice",
        originalContent = if (index % 10 == 0)
            "This is a long test message to see if our WhatsApp style read more button works perfectly in the same line as the message without breaking the layout or looking odd. It should only appear when the content is too long for the preview."
        else
            "Message $index",
        date = "12:${index} PM",
        isSender = index % 2 == 0
    )
}
