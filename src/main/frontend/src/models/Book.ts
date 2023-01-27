export interface Book {
    id: string;
    title: string;
    author: string;
    borrowingDate: string;
    reservationDate: string;

    status: string;
    version: number;
    user: any;
}