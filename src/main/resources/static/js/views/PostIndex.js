import createView from "../createView.js";

export default function PostIndex(props) {

    return `
        <header xmlns="http://www.w3.org/1999/html">
            <h1 class="mx-auto">Welcome To my blogs</h1>
        </header>
        <main>
            <div class="container row row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-3 g-3">
               
                <div class="col mb-3">
                    <div class=" card shadow-sm p-1">
                        <form id="post-form">
                            <h5> New Blog </h5>
                            <input id="title" class="border-box" name="title" type="text" placeholder="Blog Title"/>
                            <textarea cols="20"  id="content" name="content" type="text" placeholder="Content"></textarea>
                            <button id="save-btn" class="btn-sm" type="submit"> Post </button>
                        </form>
                    </div>
                </div>
                
                 ${props.posts.map(post => `${printOutBlogs(post)}`).join('')}  
                 
            </div>
        </main>
    `;
}

function printOutBlogs(post) {
    return `
            <div class="col mb-3">
                <div class=" card shadow-sm p-1">
                     <h5> ${post.title}</h5>
                      <p>${post.content}</p>
                      <button data-link="${post.id}" class="btn-sm delete-btn" type="submit"> Delete </button>
                 </div>
             </div>
    `
}

export function PostEvent() {
    createPost();
    //EditPost()
}

function createPost() {
    document.querySelector("#save-btn").addEventListener("click", function () {
        let obj = {
            title: document.querySelector("#title").value,
            content: document.querySelector("#content").value,
        }

        // let request = {
        //     method: "POST",
        //     headers: {
        //         'Content-Type': 'application/json',
        //     },
        //     body: JSON.stringify(obj)
        // };
        //
        // fetchData(
        //     {
        //         posts: `/api/posts`
        //     }, request).then((data) => {
        //     console.log(data);
        //     createView("/posts");
        // });


        const url = `http://localhost:8080/api/posts`;
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(obj)

        };
        console.log(options)
        fetch(url, options)
            .then(data => {
                console.log(data)
                createView("/posts")
            })
            .catch(error => console.error(error)); /* handle errors */
    });
}