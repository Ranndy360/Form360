
export interface IGetSendMessagesReceiver {
    id: number,
    date: string,
    confirmation: string,
    messagesId: IGetMessagesReceiver,
}

export interface IGetMessagesReceiver {
        id: number,
        date: string,
        to: string,
        message: string,
}

export interface IPostMessagesSender {
    to: string,
    message: string,
}