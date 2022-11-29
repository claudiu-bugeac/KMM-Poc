import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.text)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        init() {
            BackendApi().getWorldTopStories() { result, error in
                DispatchQueue.main.async {
                }
            }
            
            BackendApi().getMostEmailed(period: MostPopularPeriod.day30) { result, error in
                DispatchQueue.main.async {
                }
            }
        }
    }
}
