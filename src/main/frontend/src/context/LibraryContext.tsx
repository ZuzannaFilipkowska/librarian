import { createContext, useState, useEffect } from "react";

const LibraryContext = createContext({ user: {}});

export const LibraryProvider = ({ children }: any) => {

    const [user, setUser] = useState([]);


    useEffect(() => {
        fetchUser();
    }, []);

    const fetchUser= async () => {
        const response = await fetch(`/api/user`);
        const data = await response.json();
        setUser(data);
    };
    //
    // const addFeedback = async (newFeedback: any) => {
    //     const response = await fetch("/feedback", {
    //         method: "POST",
    //         headers: {
    //             "Content-Type": "application/json",
    //         },
    //         body: JSON.stringify(newFeedback),
    //     });
    //
    //     const data: any = await response.json();
    //     setFeedback([data, ...feedback]);
    // };
    //
    // const deleteFeedback = async (id: any) => {
    //     await fetch(`/feedback/${id}`, {
    //         method: "DELETE",
    //     });
    //     setFeedback(feedback.filter((el) => el.id !== id));
    // };

    // const updateFeedback = async (id: any, updatedItem: any) => {
    //     const response = await fetch(`/feedback/${id}`, {
    //         method: "PUT",
    //         headers: {
    //             "Content-Type": "application/json",
    //         },
    //         body: JSON.stringify(updatedItem),
    //     });
    //
    //     const data = await response.json();
    //
    //     // @ts-ignore
    //     setFeedback(
    //         feedback.map((item) => (item.id === id ? { ...item, ...data } : item))
    //     );
    //     setFeedbackEdit({ item: {}, edit: false });
    // };

    // Set item to be updated, mark edit mode
    // const editFeedback = (item: any) => {
    //     setFeedbackEdit({
    //         item,
    //         edit: true,
    //     });
    // };

    return (
        <LibraryContext.Provider
            value={{
            user
    }}
>
    {children}
    </LibraryContext.Provider>
);
};

export default LibraryContext;