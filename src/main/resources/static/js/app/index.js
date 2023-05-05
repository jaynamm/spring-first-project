const main = {
    //초기화
    init() {
        const btnSave = document.querySelector("#btn-save");
        if(btnSave) btnSave.addEventListener("click", () => this.save());

        const btnUpdate = document.querySelector("#btn-update");
        if(btnUpdate) btnUpdate.addEventListener("click", () => this.update());

        const btnDelete = document.querySelector("#btn-delete");
        if(btnDelete) btnDelete.addEventListener("click", () => this.delete());
    },

    // 데이터 저장
    save() {
        const data = {
            "title": document.querySelector("#title").value,
            "author": document.querySelector("#author").value,
            "content": document.querySelector("#content").value,
        };

        console.log(data);

        // fetch API 이용해서 POST 로 요청을 보내고 그 결과를 처리
        fetch("/api/v1/posts/write", {
            method: "post",
            headers: {
                "content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(data),
        })
        .then((res) => {
            if(res.status === 200 || res.status === 201) {
                // 저장 성공
                alert("글이 등록되었습니다.");
                window.location.href = "/";
            } else {
                alert("글 등록에 실패했습니다.");
            }
        })
        .catch((err) => {
            // 네트워크 오류 등 예외 발생
            alert(err.message);
        });
    },

    update() {
        const data = {
            "title": document.querySelector("#title").value,
            "content": document.querySelector("#content").value,
        };

        const id = document.querySelector("#id").value;

        // fetch API 이용해서 POST 로 요청을 보내고 그 결과를 처리
        fetch(`/api/v1/posts/${id}`, {
            method: "put",
            headers: {
                "content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(data),
        })
        .then((res) => {
            if(res.status === 200 || res.status === 201) {
                // 저장 성공
                alert("글이 수정되었습니다.");
                window.location.href = "/";
            } else {
                alert("글 수정에 실패했습니다.");
            }
        })
        .catch((err) => {
            // 네트워크 오류 등 예외 발생
            alert(err.message);
        });
    },

    delete() {
        const id = document.querySelector("#id").value;

        // fetch API 이용해서 POST 로 요청을 보내고 그 결과를 처리
                fetch(`/api/v1/posts/${id}`, {
                    method: "delete",
                })
                .then((res) => {
                    if(res.status === 200 || res.status === 201) {
                        // 저장 성공
                        alert("글이 삭제되었습니다.");
                        window.location.href = "/";
                    } else {
                        alert("글 삭제를 실패했습니다.");
                    }
                })
                .catch((err) => {
                    // 네트워크 오류 등 예외 발생
                    alert(err.message);
                });
    },
}

main.init();